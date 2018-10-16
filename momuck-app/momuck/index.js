/** @format */
import { Navigation } from 'react-native-navigation';
import { Provider } from 'react-redux';

import store from './store';
import { screen } from './screens/MenuListScreen';
import registerScreens from './registerScreens';

registerScreens(store, Provider);

if (process.env.NODE_ENV === 'development') {
    store.subscribe(() => console.log(store.getState()));
}

Navigation.startSingleScreenApp({
    screen: {
        ...screen
    }
});