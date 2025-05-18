
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Portafolio - Fátima Jaraleño</title>
  <style>
    /* Reset general */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }
    body {
      font-family: Arial, sans-serif;
      background-color: #e3f2fd;
      color: #0d47a1;
      line-height: 1.8;
      display: flex;
      flex-direction: column;
      min-height: 100vh;
    }
    header {
      background-color: #1565c0;
      color: #ffffff;
      padding: 2rem;
      text-align: center;
      border-bottom: 4px solid #82b1ff;
    }
    header h1 {
      font-size: 2.5rem;
      font-weight: bold;
    }
    header p {
      font-size: 1.2rem;
      margin-top: 0.5rem;
    }
    nav {
      margin-top: 1rem;
    }
    nav a {
      color: #bbdefb;
      text-decoration: none;
      margin: 0 1rem;
      font-size: 1.1rem;
      font-weight: bold;
      transition: color 0.3s;
    }
    nav a:hover {
      color: #ffcc80;
    }
    main {
      flex-grow: 1;
      max-width: 800px;
      margin: 2rem auto;
      padding: 1rem;
    }
    section {
      margin-bottom: 2rem;
    }
    h2 {
      font-size: 1.8rem;
      color: #0d47a1;
      border-bottom: 3px solid #82b1ff;
      display: inline-block;
      margin-bottom: 1rem;
    }
    .card {
      background-color: #ffffff;
      padding: 1.5rem;
      border-radius: 10px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      margin-bottom: 1.5rem;
    }
    .card h3 {
      color: #1976d2;
      margin-bottom: 0.8rem;
    }
    .card p {
      font-size: 1rem;
      color: #424242;
    }
    ul.skills {
      list-style: none;
      display: flex;
      flex-wrap: wrap;
      gap: 1rem;
    }
    ul.skills li {
      background-color: #bbdefb;
      padding: 0.5rem 1rem;
      border-radius: 20px;
      font-weight: bold;
      color: #0d47a1;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    .contact-info p {
      font-size: 1rem;
      margin-bottom: 0.5rem;
    }
    .button {
      display: inline-block;
      background-color: #1976d2;
      color: #ffffff;
      padding: 0.6rem 1.5rem;
      border-radius: 25px;
      text-decoration: none;
      font-weight: bold;
      transition: background-color 0.3s;
    }
    .button:hover {
      background-color: #0d47a1;
    }
    footer {
      background-color: #1565c0;
      color: #bbdefb;
      text-align: center;
      padding: 1rem;
      font-size: 0.9rem;
    }
    .language-toggle {
      text-align: center;
      margin: 1rem 0;
    }
    .language-toggle button {
      background-color: #1976d2;
      color: #ffffff;
      border: none;
      padding: 0.5rem 1rem;
      border-radius: 20px;
      cursor: pointer;
      font-weight: bold;
      transition: background-color 0.3s;
    }
    .language-toggle button:hover {
      background-color: #0d47a1;
    }
    .language-toggle button.active {
      background-color: #0d47a1;
    }
    .lang-section {
      display: none;
    }
    .lang-section.active {
      display: block;
    }
  </style>
</head>
<body>
<header>
  <h1>Fátima Jaraleño Hernández</h1>
  <p>Ingeniera en TICs | Desarrollo Web y Java</p>
  <nav>
    <a href="#about">Sobre mí</a>
    <a href="#projects">Proyectos</a>
    <a href="#skills">Habilidades</a>
    <a href="#contact">Contacto</a>
  </nav>
</header>

<main>
  <div class="language-toggle">
    <button id="btn-es" class="active">Español</button>
    <button id="btn-en">English</button>
  </div>

  <section id="about" class="lang-section active">
    <h2>Sobre mí</h2>
    <div class="card">
      <p>Soy Fátima, estudiante de Ingeniería en Tecnologías de la Información. Me apasiona el desarrollo web, la programación en Java y aprender nuevas tecnologías para mejorar la experiencia del usuario.</p>
    </div>
  </section>
  <section id="about-en" class="lang-section">
    <h2>About Me</h2>
    <div class="card">
      <p>I’m Fátima, a student of Information Technology Engineering. I am passionate about web development, Java programming, and learning new technologies to enhance user experience.</p>
    </div>
  </section>

  <section id="projects" class="lang-section active">
    <h2>Proyectos</h2>
    <div class="card">
      <h3>🌐 Base de Datos para Aula</h3>
      <p>Creé una base de datos en MySQL conectada a una web para registrar accesos al aula de cómputo.</p>
    </div>
    <div class="card">
      <h3>🌳 Árbol Binario en Java</h3>
      <p>Aplicación Java con interfaz gráfica para gestionar árboles binarios con recorridos y operaciones.</p>
    </div>

    <div class="card">
      <h3>📄 Página sobre las TICs</h3>
      <p>Desarrollo de un sistema inicial para la gestión de inventarios utilizando tecnologías web como HTML, CSS y JavaScript, con integración básica de bases de datos.</p>
    </div>
  </section>
  <section id="projects-en" class="lang-section">
    <h2>Projects</h2>
    <div class="card">
      <h3>🌐 Database for Classroom</h3>
      <p>I created a MySQL database connected to a website to register access to the computer classroom.</p>
    </div>
    <div class="card">
      <h3>🌳 Binary Tree in Java</h3>
      <p>Java application with a graphical interface to manage binary trees with traversals and operations.</p>
    </div>
    <div class="card">
      <h3>📄 Page about ICTs</h3>
      <p>Development of an initial system for inventory management using web technologies such as HTML, CSS, and JavaScript, with basic database integration.</p>
    </div>
  </section>

  <section id="testimonials" class="lang-section active">
    <h2>Testimonios</h2>
    <div class="card">
      <p>"Fátima es una profesional dedicada y apasionada por el desarrollo web. Su trabajo siempre supera las expectativas." - Cliente A</p>
    </div>
    <div class="card">
      <p>"Su habilidad para resolver problemas técnicos y su creatividad son impresionantes. Recomiendo trabajar con ella." - Cliente B</p>
    </div>
  </section>
  <section id="testimonials-en" class="lang-section">
    <h2>Testimonials</h2>
    <div class="card">
      <p>"Fátima is a dedicated professional passionate about web development. Her work always exceeds expectations." - Client A</p>
    </div>
    <div class="card">
      <p>"Her problem-solving skills and creativity are outstanding. I highly recommend working with her." - Client B</p>
    </div>
  </section>

  <section id="skills" class="lang-section active">
    <h2>Habilidades</h2>
    <ul class="skills">
      <li><i class="fas fa-code"></i> HTML5</li>
      <li><i class="fas fa-paint-brush"></i> CSS</li>
      <li><i class="fas fa-laptop-code"></i> JavaScript</li>
      <li><i class="fas fa-coffee"></i> Java</li>
      <li><i class="fas fa-database"></i> MySQL</li>
    </ul>
  </section>
  <section id="skills-en" class="lang-section">
    <h2>Skills</h2>
    <ul class="skills">
      <li><i class="fas fa-code"></i> HTML5</li>
      <li><i class="fas fa-paint-brush"></i> CSS</li>
      <li><i class="fas fa-laptop-code"></i> JavaScript</li>
      <li><i class="fas fa-coffee"></i> Java</li>
      <li><i class="fas fa-database"></i> MySQL</li>
    </ul>
  </section>

  <section id="certifications" class="lang-section active">
    <h2>Certificaciones</h2>
    <ul>
      <li>Certificación en Desarrollo Web - Platzi</li>
      <li>Certificación en Java - Oracle</li>
      <li>Certificación en Bases de Datos - Udemy</li>
      <li>Certificación en HTML5 - W3C</li>
    </ul>
  </section>
  <section id="certifications-en" class="lang-section">
    <h2>Certifications</h2>
    <ul>
      <li>Web Development Certification - Platzi</li>
      <li>Java Certification - Oracle</li>
      <li>Database Certification - Udemy</li>
      <li>HTML5 Certification - W3C</li>
    </ul>
  </section>

  <section id="contact" class="lang-section active">
    <h2>Contacto</h2>
    <div class="contact-info">
      <p>📧 jaralenohernandezfatima@gmail.com</p>
      <p>📍 Teoloyucan, Estado de México</p>
      <a href="https://github.com/FatiMazaPan" target="_blank" class="button">GitHub</a>
    </div>
  </section>
  <section id="contact-en" class="lang-section">
    <h2>Contact</h2>
    <div class="contact-info">
      <p>📧 jaralenohernandezfatima@gmail.com</p>
      <p>📍 Teoloyucan, Estado de México</p>
      <a href="https://github.com/FatiMazaPan" target="_blank" class="button">GitHub</a>
    </div>
  </section>
</main>

<footer>
  &copy; 2025 Fátima Jaraleño Hernández
</footer>

<script>
  const btnEs = document.getElementById('btn-es');
  const btnEn = document.getElementById('btn-en');
  const sectionsEs = document.querySelectorAll('.lang-section:not([id$="-en"])');
  const sectionsEn = document.querySelectorAll('.lang-section[id$="-en"]');

  btnEs.addEventListener('click', () => {
    btnEs.classList.add('active');
    btnEn.classList.remove('active');
    sectionsEs.forEach(section => section.classList.add('active'));
    sectionsEn.forEach(section => section.classList.remove('active'));
  });

  btnEn.addEventListener('click', () => {
    btnEn.classList.add('active');
    btnEs.classList.remove('active');
    sectionsEn.forEach(section => section.classList.add('active'));
    sectionsEs.forEach(section => section.classList.remove('active'));
  });
</script>
</body>
</html>
