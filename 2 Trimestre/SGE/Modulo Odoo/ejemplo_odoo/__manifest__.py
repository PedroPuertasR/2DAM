# -*- coding: utf-8 -*-
{
    'name': "ayuda_mejorar",

    'summary': """
        Módulo para ayudar a mejorar el funcionamiento de Bookify""",

    'description': """
        Los clientes de Bookify podrán dejar sus reseñas, opiniones, etc para ayudarnos
        a mejorar el servicio, informarnos de nuevas tendencias o productos que quieran
        que incluyamos y otras informaciones que nos permitan desarrollarnos.
    """,

    'author': "Bookify",
    'website': "http://www.bookify.com",

    # Categories can be used to filter modules in modules listing
    # Check https://github.com/odoo/odoo/blob/15.0/odoo/addons/base/data/ir_module_category_data.xml
    # for the full list
    'category': 'Uncategorized',
    'version': '0.1',

    # any module necessary for this one to work correctly
    'depends': ['base'],

    # always loaded
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
