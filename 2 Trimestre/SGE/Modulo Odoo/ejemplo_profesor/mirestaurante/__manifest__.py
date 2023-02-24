# -*- coding: utf-8 -*-
{
    'name': "mirestaurante",

    'summary': """
        Gestion de mi restaurante""",

    'description': """
        Este módulo permite gestionar los clientes y las reservas de mi restaurante
    """,

    'author': "El Programador de mi restaurante",
    'website': "http://www.mirestaurante.no.es",

    # Categories can be used to filter modules in modules listing
    # Check https://github.com/odoo/odoo/blob/15.0/odoo/addons/base/data/ir_module_category_data.xml
    # for the full list
    'category': 'Uncategorized',
    'version': '0.1',

    # any module necessary for this one to work correctly
    'depends': ['base'],

    # always loaded
    # en este orden, 'security/security.xml' -> 'security/ir.model.access.csv', sino dará fallos por referencias no encontradas
    # el informe (report) añadirlo al final de la colección
    'data': [
        'security/security.xml',
        'security/ir.model.access.csv',
        'views/views.xml',
        'views/templates.xml',
    ],
    # only loaded in demonstration mode
    'demo': [
        'demo/demo.xml',
    ],
}
