Feature: Crear producto

  Como: un usuario de la API de productos
  Quiero: crear un producto
  Para: poder agregar productos al catalogo

  @PostProducts
  Scenario Outline: Crear un producto exitosamente
    Given el actor establece el endpoint para crear un producto
    When el envia una solicitud POST con el producto "<title>" "<price>" "<description>" "<image>" "<category>"
    Then el codigo de respuesta deberia ser 200
    Examples:
      | title       | price | description | image | category |
      | Inka Cola    | 10    | good product | https://i.pravatar.cc | drinks |