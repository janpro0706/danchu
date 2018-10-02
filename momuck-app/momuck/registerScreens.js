import { Navigation } from 'react-native-navigation';

import {
    AppScreen
 } from './screens';

 import screens from './screens';

export default () => {
    console.log(screens);
    Navigation.registerComponent('momuck.AppScreen', () => AppScreen);
};