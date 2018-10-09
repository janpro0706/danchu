// @flow
import React from 'react';
import {
    Text,
    TouchableHighlight
} from 'react-native';
import styled from 'styled-components';


const StyledLoginButton = styled.TouchableHighlight`
    width: 100%;
    background-color: ${props => props.color || 'crimson'};
    border-radius: 30px;
    padding: 7.5px;
`;

const ButtonText = styled.Text`
    text-align: center;
    color: white;
    font-size: 18px;
`;

type Props = {
    text?: string,
    activeOpacity?: number,
    color?: string,
    underlayColor?: string,
    onPress?: Function,
    style?: Object
};

const LoginButton = ({ text, activeOpacity, color, underlayColor, onPress }: Props) => {
    return (
        <StyledLoginButton
            activeOpacity={activeOpacity}
            color={color}
            underlayColor={underlayColor}
            onPress={onPress}>
            <ButtonText>{ text }</ButtonText>
        </StyledLoginButton>
    );
};

export default LoginButton;