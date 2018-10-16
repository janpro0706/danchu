// @flow
import React, { Component } from 'react';
import { connect } from 'react-redux';

import { MenuFlatList } from '../../components/menu-list';
import { getMenus } from '../../store/reducers/menuReducer';

type Props = {
    menus: [],
    getMenus: () => void
};

class MenuListContainer extends Component<Props> {
    constructor(props) {
        super(props);

        this.onGetMenus();
    }

    onGetMenus = async () => {
        // TODO: need to do catch flag on failure
        const flag = await this.props.getMenus();
    }

    render() {
        return (
            <MenuFlatList
                menus={this.props.menus}
                onMenuPress={(url) => {}}
            />
        );
    }
}

export default connect(
    state => ({
        menus: state.menu.menus
    }),
    {
        getMenus
    }
)(MenuListContainer);