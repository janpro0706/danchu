// @flow
import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators }from 'redux';

import { LoginForm, LoginTitle } from '../../components/login';
import loginReducer, { setId, setPassword, loginRequest } from '../../store/reducers/loginReducer';


type Props = {
    id: string,
    password: string,
    setId: (id: string) => void,
    setPassword: (password: string) => void,
    loginRequest: () => void
};

class LoginContainer extends Component<Props> {
    render() {
        const {
            id,
            password,
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
                />
            </React.Fragment>
        );
    }
}



export default connect(
    (state) => ({
        id: state.login.id,
        password: state.login.password
    }),
    {
        setId,
        setPassword,
        loginRequest
    }
)(LoginContainer);