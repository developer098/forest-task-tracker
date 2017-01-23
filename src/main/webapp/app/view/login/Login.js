Ext.define('ForestTaskTracker.view.login.Login', {
    extend: 'Ext.window.Window',
    xtype: 'login',

    requires: [
        'Ext.form.Panel',

        'ForestTaskTracker.view.login.LoginController'
    ],

    controller: 'login',
    bodyPadding: 10,
    title: 'Login Window',
    closable: false,
    autoShow: true,

    items: {
            xtype: 'form',
            reference: 'form',
            items: [{
                xtype: 'textfield',
                name: 'username',
                fieldLabel: 'Имя',
                allowBlank: false
            }, {
                xtype: 'textfield',
                name: 'password',
                inputType: 'password',
                fieldLabel: 'Пароль',
                allowBlank: false
            }, {
                xtype: 'displayfield',
                hideEmptyLabel: false,
                value: 'Enter any non-blank password'
            }],
            buttons: [{
                text: 'Login',
                formBind: true,
                listeners: {
                    click: 'onLoginClick'
                }
            }]
        }
});