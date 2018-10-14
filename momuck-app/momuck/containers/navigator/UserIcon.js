// @flow
import React, { Component } from 'react';
import {
    TouchableOpacity,
    Text,
    View
} from 'react-native';
import { connect } from 'react-redux';
import { Navigation } from 'react-native-navigation';


type Props = {
    id: string
};

class UserIcon extends Component<Props> {
    onIconPress = () => {
        Navigation.handleDeepLink({
            link: 'momuck/navigation/user-icon'
        });
    }

    render() {
        const { id } = this.props;
        const isLogined = id !== '';
        const iconText = !isLogined ? 'Login' : id[0].toUpperCase();
        
        const userIconStyle = {
            backgroundColor: '#C0C0C0',
            width: 25,
            height: 25,
            borderRadius: 12.5,
            justifyContent: 'center'
        };

        return (
            <View style={isLogined && userIconStyle}>
                <TouchableOpacity onPress={this.onIconPress}>
                    <Text style={{ color: 'crimson', textAlign: 'center' }}>{iconText}</Text>
                </TouchableOpacity>
            </View>
        );
    }
}


const info = {
    screen: 'momuck.UserIcon'
};

export {
    info
};
export default connect(
    (state) => ({
        id: state.login.id
    }),
    {}
)(UserIcon);