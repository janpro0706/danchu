/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {Platform, Text, View} from 'react-native';
import styled from 'styled-components';


const AppWelcomeText = styled.Text`
  font-size: 20px;
  text-align: center;
  margin: 10px;
`;

const AppInstructionText = styled.Text`
  text-align: center;
  color: #333333;
  margin-bottom: 5px;
`;

const AppContainerView = styled.View`
  flex: 1;
  justify-content: center;
  align-items: center;
  background-color: #F4FCFF;
`;

const instructions = Platform.select({
  ios: 'Press Cmd+R to reload,\n' + 'Cmd+D or shake for dev menu',
  android:
    'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

type Props = {};
class AppScreen extends Component<Props> {
  render() {
    return (
      <AppContainerView>
        <AppWelcomeText>Welcome to Styled React Native!</AppWelcomeText>
        <AppInstructionText>To get started, edit App.js</AppInstructionText>
        <AppInstructionText>{instructions}</AppInstructionText>
      </AppContainerView>
    );
  }
}

const screen = {
    screen: 'momuck.AppScreen',
    title: 'App'
};

export { screen };

export default AppScreen;