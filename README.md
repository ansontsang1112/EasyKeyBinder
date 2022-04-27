# EasyKeyBinder
A simple plugin with for player to bind commands to "SHIFT + F" and "SHIFT + Q" easily.

## Installation
1. Download and put the plugin into /plugins/
2. Restart or load the plugin into the server
3. Edit the configuration in the plugin
4. Happy to use

## Requirement
Java 11 or above

## Commands
| Command | Description | Permission |
| ------ | ------ | ------ |
| ekb-reload | reload the plugin | ekb.admin (Default OP) |

## Permissions for SHIFT-F and SHIFT-Q (If enabled permission)
| Action | Permission |
| ------ | ------ |
| SHIFT-F | ekb.shift.f |
| SHIFT-Q | ekb.shift.q |

## Reminder
The player should obtain the permission for the command which you wish player to execute via SHIFT-F / SHIFT-Q.
```
Example: SHIFT-F bound to "/say hello". The player should contain the permission node: minecraft.command.say
```

## config.yml
```yml
#EasyKeyBinder Configuration File

#Key Binding
binding:
  #Key Binding for "SHIFT + F"
  shiftF:
    enable: false
    command: ""
    permission: false
  #Key Binding for "SHIFT + Q"
  shiftQ:
    enable: false
    command: ""
    permission: false

#Lang Section:
lang:
  prefix: "EKB// "
  permission-denied: "You do not have enough permission to perform this action"
  reload: "Configuration Successfully reloaded"
```
