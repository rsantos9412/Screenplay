# language: es
Característica: Búsqueda en Wikipedia
  Como usuario de Wikipedia
  Quiero poder buscar términos
  Para encontrar información relevante

  @casoBusqueda
  Escenario: Buscar un término en Wikipedia
    Dado que Carlos está en la página de Wikipedia
    Cuando busca el término "Patrón de diseño Screenplay"
    Entonces debería ver un artículo relacionado con "Patrón de diseño Screenplay"