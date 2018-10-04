// @flow
import React, { Component } from 'react';
import {
    Text
} from 'react-native';
import styled from 'styled-components';


const LoginTitleText = styled.Text`
    font-size: 50;
    padding-bottom: 100;
    margin-top: -150;
`;

type Props = {

};

class LoginTitle extends Component<Props> {
    render() {
        return (
            <LoginTitleText>Momuck</LoginTitleText>
        );
    }
}

export default LoginTitle;