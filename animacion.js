// Botón flotante de desplazamiento hacia arriba
const scrollToTopButton = document.getElementById("scrollToTop");

// Mostrar el botón cuando se hace scroll
window.onscroll = () => {
    if (document.body.scrollTop > 200 || document.documentElement.scrollTop > 200) {
        scrollToTopButton.style.display = "block";
    } else {
        scrollToTopButton.style.display = "none";
    }
};

// Acción del botón de desplazamiento hacia arriba
scrollToTopButton.addEventListener("click", () => {
    window.scrollTo({ top: 0, behavior: "smooth" });
});
