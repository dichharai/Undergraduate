# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('tripadvise', '0024_auto_20160414_1230'),
    ]

    operations = [
        migrations.AlterField(
            model_name='review',
            name='user_Id',
            field=models.ForeignKey(to='tripadvise.CustomUser'),
        ),
    ]
