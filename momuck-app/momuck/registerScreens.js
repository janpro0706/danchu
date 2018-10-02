import { Navigation } from 'react-native-navigation';
import { Provider } from 'react-redux';

import store from './store';
import AppScreen, { screen as appScreen } from './screens/AppScreen';

function registerWithRedux(store, Provider) {
    return (screenName, component) => {
        Navigation.registerComponent(screenName, () => component, store, Provider);
    };
}

export default (store, Provider) => {
    const register = registerWithRedux(store, Provider);

    register(appScreen.screen, AppScreen);
};