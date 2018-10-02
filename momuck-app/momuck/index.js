/** @format */
import { Navigation } from 'react-native-navigation';

import { screen } from './screens/AppScreen';
import registerScreens from './registerScreens';

registerScreens();

Navigation.startSingleScreenApp({
    screen: {
        ...screen
    }
});