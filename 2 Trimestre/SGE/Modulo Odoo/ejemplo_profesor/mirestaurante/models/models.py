# -*- coding: utf-8 -*-

from email.policy import default
from odoo import models, fields, api

class mirestaurante_cliente(models.Model):
    _name = 'mirestaurante.cliente'

    name = fields.Char(string="Nombre", required=True, help="Introduce el nombre del cliente")
    email = fields.Char(string="Email", required=True, help="Introduce el email del cliente")
    asiduo = fields.Boolean(string="Asiduo", default=False, help="El cliente acude normalmente al mirestaurante")
    reservas = fields.One2many("mirestaurante.reserva", "cliente", string="Reservas", readonly="1")

class mirestaurante_reserva(models.Model):
    _name = 'mirestaurante.reserva'

    codigo = fields.Integer(string="Código", required=True, help="Código de la reserva")
    fecha = fields.Date(string="Fecha de reserva", required=True, help="Fecha de la reserva")
    tipo = fields.Selection([('0', 'Carta'), ('1', 'Menú'), ('2', 'Petición')], required=True, help="Tipo de reserva")
    consideraciones = fields.Text(string="Consideraciones", default="Ninguna", help="Consideraciones a tener en cuenta sobre la reserva")
    cliente = fields.Many2one("mirestaurante.cliente", required=True, string="Cliente", ondelete="cascade")
    

