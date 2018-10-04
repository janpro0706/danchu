import { Navigation } from 'react-native-navigation';
import { Provider } from 'react-redux';

import store from './store';
import AppScreen, { screen as appScreen } from './screens/AppScreen';
import LoginScreen, { screen as loginScreen } from './screens/LoginScreen';

function registerWithRedux(store, Provider) {
    return (screenName, component) => {
        Navigation.registerComponent(screenName, () => component, store, Provider);
    };
}

export default (store, Provider) => {
    const register = registerWithRedux(store, Provider);

    register(appScreen.screen, AppScreen);
    register(loginScreen.screen, LoginScreen);
};