// @flow
import React, { Component } from 'react';
import { Image } from 'react-native';
import styled from 'styled-components';


const PlaceholderView = styled.View`
    background-color: ${props => props.source ? '#FFFFFF' : '#C0C0C0'};
`;

const FoodImage = styled.Image`
    width: ${props => props.width || '100%'};
    height: ${props => props.height || '100%'};
`;

type Props = {
    source?: string,
    ratio: number
};

type State = {
    width: number,
    height: number
};

class PlaceholderImage extends Component<Props, State> {
    state = {
        width: 0,
        height: 0
    };

    _onLayout = (event: any) => {
        const containerWidth = event.nativeEvent.layout.width;

        this.setState(state => ({
            width: containerWidth,
            height: containerWidth * this.props.ratio
        }));
    };

    render() {
        const { source } = this.props;

        return (
            <PlaceholderView onLayout={this._onLayout}>
                <FoodImage
                    width={this.state.width}
                    height={this.state.height}
                    source={require('../../assets/login-background.min.jpg')}
                />
            </PlaceholderView>
        )
    }
}

export default PlaceholderImage;