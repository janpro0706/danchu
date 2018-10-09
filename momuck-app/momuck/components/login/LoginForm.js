// @flow
import React, { Component } from 'react';
import styled from 'styled-components';

import { LoginButton } from '.';


const LoginFormView = styled.View`
    width: 60%;
`;

const LoginFormTextInput = styled.TextInput`
    width: 100%;
    margin-bottom: 10px;
    padding: 10px;
    background-color: #F0F0F0;
    opacity: 0.9;
    border-radius: 30px;
    color: black;
`;

const LoginSubmitButton = ({ text, onPress }: {
    text: string,
    onPress: Function
}) => {
    return (
        <LoginButton
            text={text}
            onPress={onPress}
            activeOpacity={0.7}
            color="#DC143C"
            underlayColor="#CB032B"
        />
    );
}

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
                    text="로그인"
                    onPress={() => console.log('hello')}
                />
            </LoginFormView>
        );
    }
}

export default LoginForm;