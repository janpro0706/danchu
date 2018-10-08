// @flow
import React, { Component } from 'react';
import {
    TextInput,
    Button,
    View
} from 'react-native';
import styled from 'styled-components';


const LoginFormView = styled.View`
    width: 40%;
`;

const LoginFormTextInput = styled.TextInput`
    width: 100%;
`;

const LoginSubmitButton = styled.Button`
    width: 100%;
`;

type Props = {
    id: string,
    password: string,
    setId: (id: string) => void,
    setPassword: (password: string) => void,
    loginRequest: () => void
};

class LoginForm extends Component<Props> {
    render() {
        return (
            <LoginFormView>
                <LoginFormTextInput
                    placeholder="ID"
                    maxLength={15}
                    autoCapitalize="none"
                    value={this.props.id || ''}
                    onChangeText={(id: string) => this.props.setId(id)}
                />
                <LoginFormTextInput
                    placeholder="PW"
                    maxLength={15}
                    secureTextEntry
                    value={this.props.password || ''}
                    onChangeText={(pw: string) => this.props.setPassword(pw)}
                />
                <LoginSubmitButton
                    title="로그인"
                    onPress={this.props.loginRequest}
                />
            </LoginFormView>
        );
    }
}

export default LoginForm;