#-*- coding: utf-8 -*-

from email.policy import default
from odoo import models, fields, api


class ejemplo_odoo_cliente(models.Model):
    _name = 'ejemplo_odoo.cliente'

    @api.depends('min_gastado', 'max_gastado')
    def __calcularMedia(self):
        for i in self:
            media = (i.max_gastado + i.min_gastado) / 2

            i.media_gastado = media
    media_gastado = fields.Float(string="Media gastado", compute=__calcularMedia, required=False, help="Media de gasto")
    name = fields.Char(string="Nombre", required=True, help="Nombre del cliente")
    email = fields.Char(string="Email", required=True, help="Email del cliente")
    club_lectura = fields.Boolean(string="Club de lectura", default=False, help="Está suscrito al club de lectura")

    comentario = fields.One2many("ejemplo_odoo.comentario", "cliente", string="Comentario", readonly="1")

class ejemplo_odoo_comentario(models.Model):
    _name = 'ejemplo_odoo.comentario'
    min_gastado = fields.Float(string="min_gastado", required=True, help="Mínimo gastado")
    max_gastado = fields.Float(string="max_gastado", required=True, help="Máximo gastado")
    codigo = fields.Integer(string="ID", required=True, help="Código de ID")
    fecha = fields.Date(string="Fecha de comentario", required=True, help="Fecha del comentario")
    tipo = fields.Selection([('0', 'Opinión'), ('1', 'Queja'), ('2', 'Petición')], required=True, help="Tipo de comentario")
    cliente = fields.Many2one("ejemplo_odoo.cliente", required=True, string="Cliente", ondelete="cascade")