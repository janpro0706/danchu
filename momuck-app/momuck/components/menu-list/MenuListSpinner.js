// @flow
import React from 'react';
import styled from 'styled-components';


const AbsoluteCenterView = styled.View`
    position: absolute;
    width: 100%;
    padding-top: 50%;
`;

const CenterSpinner = styled.ActivityIndicator`
    text-align: center;
`;

type Props = {
    isPending: boolean
};

const MenuListSpinner = ({ isPending }: Props) => {
    return (
        <AbsoluteCenterView>
            <CenterSpinner size="large" animating={isPending} />
        </AbsoluteCenterView>
    );
};

export default MenuListSpinner;