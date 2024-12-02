
Feature: Eliminar producto

  Como: un usuario de la API de productos
  Quiero: eliminar un producto
  Para: poder retirar un producto del catalogo

  @DeleteProduct
  Scenario: Eliminar un producto correctamente
    Given el actor establece el endpoint para eliminar el producto
    When el envia una solicitud DELETE con el producto
    Then el codigo de respuesta deberia ser 200




