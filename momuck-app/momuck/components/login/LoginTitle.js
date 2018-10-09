// @flow
import React, { Component } from 'react';
import {
    Text
} from 'react-native';
import styled from 'styled-components';


const LoginTitleText = styled.Text`
    font-size: 50;
    padding-bottom: 50;
    margin-top: -100;
`;

type Props = {

};

class LoginTitle extends Component<Props> {
    render() {
        return (
            <LoginTitleText>MOMUCK</LoginTitleText>
        );
    }
}

export default LoginTitle;