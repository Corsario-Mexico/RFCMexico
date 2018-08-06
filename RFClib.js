'use strict';

// Arreglo de Vocales
const Vocales = ['A', 'E', 'I', 'O', 'U'];
// Arreglo de Elementos del Apellidos a Ignorar
const IgnorarApellidos = ['DE', 'DEL', 'LA', 'LAS', 'LOS', 'MAC', 'MC', 'MI', 'VAN', 'VON', 'Y'];
// Arreglo de Elementos del Nombre a Ignorar, es igual a los de apellidos agregando José y María
const IgnorarNombres = IgnorarApellidos.slice();
IgnorarNombres.push('JOSE', 'MARIA');
IgnorarNombres.sort();
// Arreglo de Prefijos de RFC Inválidos
/* eslint-disable indent */
const PrefijosInvalidos = ['BUEI', 'BUEY', 'CACA', 'CACO', 'CAGA', 'CAGO', 'CAKA', 'CAKO', 'COGE',
                           'COJA', 'COJE', 'COJI', 'COJO', 'CULO', 'FETO', 'GUEY', 'JOTO', 'KACA',
                           'KACO', 'KAGA', 'KAGO', 'KAKA', 'KOGE', 'KOJO', 'KULO', 'MAME', 'MAMO',
                           'MEAR', 'MEAS', 'MEON', 'MION', 'MOCO', 'MULA', 'PEDA', 'PEDO', 'PENE',
                           'PUTA', 'PUTO', 'QULO', 'RATA', 'RUIN'];
/* eslint-enable indent */

// Validación de Arreglos
console.log('-- Vocales --');

Vocales.forEach((vocal, iCounter) => {
  console.log(iCounter + ': ' + vocal);
});

// Validación de Arreglos
console.log('-- Apellidos --');

IgnorarApellidos.forEach((apellido, iCounter) => {
  console.log(iCounter + ': ' + apellido);
});

console.log('-- Nombres --');

IgnorarNombres.forEach((nombre, iCounter) => {
  console.log(iCounter + ': ' + nombre);
});

console.log('-- Prefijos --');

PrefijosInvalidos.forEach((prefijo, iCounter) => {
  console.log(iCounter + ': ' + prefijo);
});

function LimpiaCadena (cadena) {
  let limpia = cadena.normalize('NFD').replace(/[\u0300-\u036f]/g, '').toUpperCase();
  limpia = limpia.startsWith('CH') ? 'C' + limpia.slice(2) : limpia;
  limpia = limpia.startsWith('LL') ? 'L' + limpia.slice(2) : limpia;
  return limpia;
}

console.log(LimpiaCadena('ÀÁÂÃÄÅĄàáâãäåąßÒÓÔÕÕÖØŐòóôőõöøĎďDŽdžÈÉÊËĘèéêëęðÇçČčĆćÐÌÍÎÏìíîïÙÚÛÜŰùűúûüĽĹŁľĺłÑŇŃňñńŔŕŠŚšśŤťŸÝÿýŽŻŹžżź'));
console.log(LimpiaCadena('chávez'));
console.log(LimpiaCadena('llaven'));

function generaInicioFisica (pPaterno, pMaterno, pNombre, pNacimiento) {
  let apellidoPaterno = LimpiaCadena(pPaterno);
  let apellidoMaterno = LimpiaCadena(pMaterno);
  let nombres = LimpiaCadena(pNombre);
  if (apellidoPaterno.length === 0) {
    console.error('No hay Apellido Paterno');
  }
  if (nombres.length === 0) {
    console.error('No hay Nombre');
  }
  if (isNaN(pNacimiento)) {
    console.error('La fecha de Nacimiento no es un número');
  }
  let ano = pNacimiento.substr(0, 4);
  let mes = (pNacimiento.substr(4, 2)) - 1;
  let dia = pNacimiento.substr(6, 2);
  let dFecha = new Date(ano, mes, dia);
  return apellidoPaterno + ' ' + apellidoMaterno + ' ' + nombres + ' ' + dFecha;
}

console.log(generaInicioFisica('sol', 'llaven', 'david jonathan', '19720309'));
console.log(generaInicioFisica('', 'no', 'apellido', '19720309'));
console.log(generaInicioFisica('no', 'nombre', '', '19720309'));
console.log(generaInicioFisica('sol', '', 'david jonathan', '19720309'));
console.log(generaInicioFisica('sol', '', 'david', 'jonathan'));

// var str = "Mr Blue has a blue house and a blue car";
// var res = str.replace(/blue|house|car/gi, function (x) {
//     return x.toUpperCase();
// });
// console.log(res);

// String.prototype.latinise = function() {
// return this.replace(/[^A-Za-z0-9]/g, function(x) { return latin_map[x] || x; })
// };
