// combine moduleVariables from all pages

import LoginVars from './login/moduleVariables';

let declarations = [];
let entryComponents = [];

[ LoginVars ].forEach((vars) => {
  declarations = declarations.concat(vars.declarations);
  entryComponents = entryComponents.concat(vars.entryComponents);
});

export { declarations, entryComponents };
