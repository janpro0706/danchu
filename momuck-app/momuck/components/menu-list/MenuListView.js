// @flow
import React, { Component, type Node } from 'react';
import { View } from 'react-native';

type Props = {
    children?: Node
};

class MenuListView extends Component<Props> {
    render() {
        return (
            <View>
                {this.props.children}
            </View>
        );
    }
}

export default MenuListView;