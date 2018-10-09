// @flow
import React, { Component, type Node } from 'react';
import {
    ImageBackground
} from 'react-native';
import styled from 'styled-components';

import loginBackground from '../../assets/login-background.jpg';


const CenterView = styled.View`
    flex: 1;
    justify-content: center;
    align-items: center;
`;

const LoginBackgroundImage = styled.ImageBackground`
    width: 100%;
    padding-top: 178%;
    position: absolute;
    opacity: 0.6;
`;

type Props = {
    children: Node
};

class LoginView extends Component<Props> {
    render() {
        return (
            <CenterView>
                <LoginBackgroundImage source={loginBackground} />
                {this.props.children}
            </CenterView>
        );
    }
}

export default LoginView;