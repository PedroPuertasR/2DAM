#-*- coding: utf-8 -*-

from email.policy import default
from odoo import models, fields, api


class ejemplo_odoo_cliente(models.Model):
    _name = 'ejemplo_odoo.cliente'

    name = fields.Char(string="Nombre", required=True, help="Nombre del cliente")
    email = fields.Char(string="Email", required=True, help="Email del cliente")
    club_lectura = fields.Boolean(string="Club de lectura", default=False, help="Está suscrito al club de lectura")
    comentario = fields.One2many("ejemplo_odoo.comentario", "cliente", string="Comentario", readonly="1")

class ejemplo_odoo_comentario(models.Model):
    _name = 'ejemplo_odoo.comentario'

    codigo = fields.Integer(string="ID", required=True, help="Código de ID")
    fecha = fields.Date(string="Fecha de comentario", required=True, help="Fecha del comentario")
    tipo = fields.Selection([('0', 'Opinión'), ('1', 'Queja'), ('2', 'Petición')], required=True, help="Tipo de comentario")
    cliente = fields.Many2one("ejemplo_odoo.cliente", required=True, string="Cliente", ondelete="cascade")