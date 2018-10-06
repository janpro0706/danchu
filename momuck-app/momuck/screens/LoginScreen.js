// @flow
import React, { Component } from 'react';
import { connect } from 'react-redux';

import { LoginContainer } from '../containers/login';
import { LoginView } from '../components/login';


type Props = {

};

class LoginScreen extends Component<Props> {
    static navigatorStyle = {
        navBarHidden: true
    };

    render() {
        return (
            <LoginView>
                <LoginContainer />
            </LoginView>
        );
    }
}


const screen = {
    screen: 'momuck.LoginScreen'
};

export { screen };
export default connect(
    (state) => ({
        isLogined: state.login.isLogined
    }),
    {}
)(LoginScreen);