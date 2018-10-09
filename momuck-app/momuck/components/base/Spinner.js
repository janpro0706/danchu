import React from 'react';
import { Text, Animated } from 'react-native';
import styled from 'styled-components';


const Spinner = () => {
    const animation = new Animated.Value(0);

    return () => {
        const rotate = animation.interpolate({
            inputRange: [0, 1],
            outputRange: ['0deg', '360deg']
        });

        Animated.loop(
            Animated.timing(animation, { toValue: 1, duration: 2000 })
        ).start();

        return (
            <Animated.View style={{
                transform: [{
                    rotate: rotate
                }]
            }}>
                <Text>Please Wait...</Text>
            </Animated.View>
        );
    };
};



export default Spinner();