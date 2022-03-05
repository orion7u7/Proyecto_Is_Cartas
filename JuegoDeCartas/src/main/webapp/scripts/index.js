
const botonadmin = document.querySelector('.administrador');
const admin = document.querySelector('.admin');
const adminpas = document.querySelector('.adminpas');
const botonuser = document.querySelector('.usuario');
const user = document.querySelector('.user');

botonadmin.addEventListener('click', (e) => {
    e.preventDefault();
    admin.classList.remove('oculto');
    adminpas.classList.remove('oculto');
    botonuser.classList.remove('oculto');
    botonadmin.classList.add('oculto');
    user.classList.add('oculto');
});

botonuser.addEventListener('click', (e) => {
    e.preventDefault();
    admin.classList.add('oculto');
    adminpas.classList.add('oculto');
    botonuser.classList.add('oculto');
    botonadmin.classList.remove('oculto');
    user.classList.remove('oculto');
});


