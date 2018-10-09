import React from 'react';
import styled from 'styled-components';

const Dimmer = styled.View`
    width: 100%;
    height: 100%;
    position: absolute;
    background-color: #505050;
    opacity: 0.6;
    z-index: 9999;
`;

export default Dimmer;