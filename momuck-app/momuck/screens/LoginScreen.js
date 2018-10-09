// @flow
import React, { Component } from 'react';
import { connect } from 'react-redux';

import { LoginContainer } from '../containers/login';
import { LoginView } from '../components/login';

import { Dimmer, Spinner } from '../components/base';


type Props = {
    isLogined: boolean,
    dimmer: boolean
};

class LoginScreen extends Component<Props> {
    static navigatorStyle = {
        navBarHidden: true
    };

    render() {
        return (
            <LoginView>
                {this.props.dimmer && 
                <React.Fragment>
                    <Dimmer />
                    <Spinner />
                </React.Fragment>}
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
        isLogined: state.login.request.isLogined,
        dimmer: state.screen.dimmer
    }),
    {}
)(LoginScreen);