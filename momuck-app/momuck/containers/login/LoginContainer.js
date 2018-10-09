// @flow
import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators }from 'redux';

import { LoginForm, LoginTitle } from '../../components/login';
import {
    setId,
    setPassword,
    loginRequest
} from '../../store/reducers/loginReducer';


type Props = {
    id: string,
    password: string,
    isLogined: boolean,
    isProgressing: boolean,
    setId: (id: string) => void,
    setPassword: (password: string) => void,
    loginRequest: () => void
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
            loginRequest
        } = this.props;

        return (
            <React.Fragment>
                <LoginTitle />
                <LoginForm
                    setId={setId}
                    setPassword={setPassword}
                    loginRequest={loginRequest}
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
        setPassword,
        loginRequest
    }
)(LoginContainer);