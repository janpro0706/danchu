// @flow
import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators }from 'redux';

import { LoginForm, LoginTitle } from '../../components/login';
import {
    setId,
    setPassword
} from '../../store/reducers/loginReducer';


type Props = {
    id: string,
    password: string,
    isLogined: boolean,
    isProgressing: boolean,
    setId: (id: string) => void,
    setPassword: (password: string) => void,
    requestLogin: () => void
};

class LoginContainer extends Component<Props> {
    render() {
        const {
            id,
            password,
            isLogined,
            isProgressing,
            setId,
            setPassword,
            requestLogin
        } = this.props;

        return (
            <React.Fragment>
                <LoginTitle />
                <LoginForm
                    setId={setId}
                    setPassword={setPassword}
                    requestLogin={requestLogin}
                    id={id}
                    password={password}
                    isLogined={isLogined}
                    isProgressing={isProgressing}
                />
            </React.Fragment>
        );
    }
}



export default connect(
    (state) => ({
        id: state.login.id,
        password: state.login.password,
        isLogined: state.login.request.isLogined,
        isProgressing: state.login.request.isProgressing
    }),
    {
        setId,
        setPassword
    }
)(LoginContainer);