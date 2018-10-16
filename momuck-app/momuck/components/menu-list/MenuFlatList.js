// @flow
import React, { Component, type Element } from 'react';
import {
    View,
    FlatList,
    Text,
    ImageBackground,
    TouchableHighlight
} from 'react-native';
import styled from 'styled-components';

import { PlaceholderImage } from '../base';


const ListItemText = styled.Text`
    padding: 10px;
    font-size: 18px;
`;

const ListItem = (props: {
    text: string,
    img: string,
    onPress: Function
}) => {
    const { text, img, onPress } = props;

    return (
        <TouchableHighlight underlayColor="#909090" onPress={onPress}>
            <View>
                <PlaceholderImage source={img} ratio={0.75} />
                <ListItemText>
                    {text}
                </ListItemText>
            </View>
        </TouchableHighlight>
    );
};

type Props = {
    menus: [],
    onMenuPress: (url: string) => void
};

class MenuFlatList extends Component<Props> {
    render() {
        const renderItem = ({item}) => {
            return (
                <ListItem
                    text={item.title}
                    img={item.img}
                    onPress={() => { this.props.onMenuPress(item.title) }}
                />
            );
        };

        return (
            <View>
                <FlatList
                    data={this.props.menus}
                    renderItem={renderItem}
                    refreshing={false}
                    onRefresh={() => {}}
                />
            </View>
        );
    }
}

export default MenuFlatList;