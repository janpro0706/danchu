// @flow
import React, { Component } from 'react';
import { connect } from 'react-redux';

import { LoginContainer } from '../containers/login';
import { LoginView } from '../components/login';
import { Dimmer, Spinner } from '../components/base';

import { requestLogin } from '../store/reducers/loginReducer';

type Props = {
    isLogined: boolean,
    dimmer: boolean,
    requestLogin: () => void,
    navigator: any
};

class LoginScreen extends Component<Props> {
    static navigatorStyle = {
        navBarHidden: true
    };

    onLoginRequest = async () => {
        const ret = await this.props.requestLogin();
        
        if (ret === true) {
            this.props.navigator.pop();
        }
    }

    render() {
        return (
            <LoginView>
                {this.props.dimmer && 
                <React.Fragment>
                    <Dimmer />
                    <Spinner />
                </React.Fragment>}
                <LoginContainer requestLogin={this.onLoginRequest} />
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
    {
        requestLogin
    }
)(LoginScreen);