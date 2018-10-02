import { Navigation } from 'react-native-navigation';

import App from './App';

export default () => {
    Navigation.registerComponent('momuck.App', () => App);
};