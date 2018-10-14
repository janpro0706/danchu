// @flow
import React, { Component } from 'react';
import styled from 'styled-components';
import { connect } from 'react-redux';
import { Navigation } from 'react-native-navigation';

import { MenuListView } from '../components/menu-list';
import { MenuListContainer } from '../containers/menu-list';

import { setId } from '../store/reducers/loginReducer';


type Props = {
    navigator: any,
    id: string,
    setId: (id: string) => void
};

class MenuListScreen extends Component<Props> {
    static navigatorButtons = {
        rightButtons: [
            {
                component: 'momuck.UserIcon',
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
        if (event.type === 'DeepLink' && event.link === 'momuck/navigation/user-icon') {
            if (this.props.id === '') {
                // go to LoginScreen when not logined
                this.props.navigator.push({
                    screen: 'momuck.LoginScreen'
                });
            } else {
                // TODO: logout
                this.props.setId('');
            }
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
export default connect(
    (state) => ({
        id: state.login.id
    }),
    {
        setId
    }
)(MenuListScreen);