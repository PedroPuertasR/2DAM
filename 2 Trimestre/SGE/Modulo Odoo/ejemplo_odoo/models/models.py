#-*- coding: utf-8 -*-

from email.policy import default
from odoo import models, fields, api


class ayuda_mejorar_cliente(models.Model):
    _name = 'ayuda_mejorar.cliente'
    _description = 'ayuda_mejorar.ayuda_mejorar'

    name = fields.Char(string="Nombre", required=True, help="Nombre del cliente")
    email = fields.Char(string="Email", required=True, help="Email del cliente")
    club_lectura = fields.Boolean(string="Club de lectura", default=False, help="Está suscrito al club de lectura")
    reservas = fields.One2many("ayuda_mejorar.comentario", "comentario", string="Comentario", readonly="1")

class ayuda_mejorar_comentario(models.Model):
    _name = 'ayuda_mejorar.comentario'

    codigo = fields.Integer(string="ID", required=True, help="Código de ID")
    fecha = fields.Date(string="Fecha de comentario", required=True, help="Fecha del comentario")
    tipo = fields.Selection([('0', 'Opinión'), ('1', 'Queja'), ('2', 'Petición')], required=True, help="Tipo de comentario")
    cliente = fields.Many2one("mirestaurante.cliente", required=True, string="Cliente", ondelete="cascade")
    