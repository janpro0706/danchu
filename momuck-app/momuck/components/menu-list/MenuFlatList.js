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


const dummy = [
    '족발', '치킨', '짜장면', '탕수육', '피자', '삼겹살', '닭발', '곱창', '파스타', '돈까스', '냉모밀', '스시', '회',
];

const ListItemText = styled.Text`
    padding: 10px;
    font-size: 18px;
`;

const ListItem = ({ text, image }: { text: string, image?: Element<typeof ImageBackground> }) => {
    return (
        <TouchableHighlight underlayColor="#909090" onPress={() => console.log(text + ' touced.')}>
            <View>
                {image || <PlaceholderImage />}
                <ListItemText>
                    {text}
                </ListItemText>
            </View>
        </TouchableHighlight>
    );
};

type Props = {

};

class MenuFlatList extends Component<Props> {
    render() {
        return (
            <View>
                <FlatList
                    data={dummy}
                    renderItem={({item}) => (<ListItem text={item} />)}
                    refreshing={false}
                    onRefresh={() => {}}
                />
            </View>
        );
    }
}

export default MenuFlatList;