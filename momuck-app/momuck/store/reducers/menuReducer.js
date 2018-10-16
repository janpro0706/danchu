// @flow

// action types
const PREFIX = 'momuck/menu';

const GET_MENUS = `${PREFIX}/getMenus`;
const PENDING_MENUS = `${PREFIX}/pendingMenus`;
const FETCH_MENUS = `${PREFIX}/fetchMenus`;

// action flow types
type GetMenusAction = {
    type: 'momuck/menu/getMenus',
    offset?: number
};

type PendingMenusAction = {
    type: 'momuck/menu/pendingMenus'
};

type FetchMenusAction = {
    type: 'momuck/menu/fetchMenus',
    menus: Menus
};

type MenuAction = GetMenusAction & PendingMenusAction & FetchMenusAction;

// store flow types
type Menu = {
    title: string,
    category: string,
    star: number,
    img: string,
    description?: string
};

type Menus = Array<Menu>;

type MenuState = {
    menus: Menus,
    isPending: boolean
};

// action creators
const dummyMenus = [
    {
        title: '족발',
        category: '한식',
        star: 5,
        img: '../../assets/login-background.jpg'
    },
    {
        title: '치킨',
        category: '치킨',
        star: 5,
        img: '../../assets/login-background'
    },
    {
        title: '피자',
        category: '양식',
        star: 5,
        img: '../../assets/login-background.jpg'
    },
    {
        title: '돈까스',
        category: '일식',
        star: 5,
        img: '../../assets/login-background.jpg'
    },
    {
        title: '초밥',
        category: '일식',
        star: 5,
        img: '../../assets/login-background.jpg'
    },
    {
        title: '회',
        category: '일식',
        star: 5,
        img: '../../assets/login-background.jpg'
    }
]

function getMenus(offset?: number) {
    return async function(dispatch: any) {
        dispatch(pendingMenus());

        return new Promise(resolve => {
            setTimeout(function() {
                dispatch(fetchMenus(dummyMenus));
                resolve(true);
            }, 1000);
        });
    };
}

function pendingMenus() {
    return {
        type: PENDING_MENUS
    };
}

function fetchMenus(menus: Menus) {
    return {
        type: FETCH_MENUS,
        menus
    };
}

// reducers
const initialState: MenuState = {
    menus: [],
    isPending: false
};

function menu(state: MenuState = initialState, action: MenuAction) {
    switch (action.type) {
        case PENDING_MENUS:
            return {
                ...state,
                isPending: true
            };
        case FETCH_MENUS:
            return {
                ...state,
                menus: action.menus,
                isPending: false
            };
        default:
            return state;
    }
}

export {
    getMenus
};
export default menu;