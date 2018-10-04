/** @format */
import { Navigation } from 'react-native-navigation';
import { Provider } from 'react-redux';

import store from './store';
import { screen } from './screens/LoginScreen';
import registerScreens from './registerScreens';

registerScreens(store, Provider);

Navigation.startSingleScreenApp({
    screen: {
        ...screen
    }
});