// @flow
import React, { Component } from 'react';
import styled from 'styled-components';

import { MenuListView } from '../components/menu-list';
import { MenuListContainer } from '../containers/menu-list';


type Props = {
    navigator: any
};

class MenuListScreen extends Component<Props> {
    static navigatorButtons = {
        rightButtons: [
            {
                title: 'Guest',
                id: 'user-icon',
                buttonColor: 'crimson'
            }
        ]
    };

    constructor(props: Props) {
        super(props);

        this.props.navigator.setOnNavigatorEvent(this.onNavigatorEvent);
    }

    onNavigatorEvent = (event: any) => {
        if (event.type === 'NavBarButtonPress') {
            console.log(event.id + ' pressed.');
        }
    }

    render() {
        return (
            <MenuListView>
                <MenuListContainer />
            </MenuListView>
        );
    }
}

const screen = {
    screen: 'momuck.MenuListScreen',
    title: '오늘은 뭐먹지?'
};

export { screen };
export default MenuListScreen;