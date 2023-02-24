# -*- coding: utf-8 -*-
# from odoo import http


# class EjemploOdoo(http.Controller):
#     @http.route('/ejemplo_odoo/ejemplo_odoo', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/ejemplo_odoo/ejemplo_odoo/objects', auth='public')
#     def list(self, **kw):
#         return http.request.render('ejemplo_odoo.listing', {
#             'root': '/ejemplo_odoo/ejemplo_odoo',
#             'objects': http.request.env['ejemplo_odoo.ejemplo_odoo'].search([]),
#         })

#     @http.route('/ejemplo_odoo/ejemplo_odoo/objects/<model("ejemplo_odoo.ejemplo_odoo"):obj>', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('ejemplo_odoo.object', {
#             'object': obj
#         })
