// @flow
import React, { Component } from 'react';
import styled from 'styled-components';


const CenterView = styled.View`
    flex: 1;
    justify-content: center;
    align-items: center;
`;

type Props = {

};

class LoginView extends Component<Props> {
    render() {
        return (
            <CenterView>
                {this.props.children}
            </CenterView>
        );
    }
}

export default LoginView;