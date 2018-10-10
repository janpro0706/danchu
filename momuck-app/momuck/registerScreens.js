import { Navigation } from 'react-native-navigation';
import { Provider } from 'react-redux';

import store from './store';
import LoginScreen, { screen as loginScreen } from './screens/LoginScreen';
import MenuListScreen, { screen as menuListScreen } from './screens/MenuListScreen';

function registerWithRedux(store, Provider) {
    return (screenName, component) => {
        Navigation.registerComponent(screenName, () => component, store, Provider);
    };
}

export default (store, Provider) => {
    const register = registerWithRedux(store, Provider);

    register(loginScreen.screen, LoginScreen);
    register(menuListScreen.screen, MenuListScreen);
};