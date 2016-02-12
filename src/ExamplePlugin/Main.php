<?php

namespace ExamplePlugin;

use BukkitPE\plugin\PluginBase;  //  Our pluginbase which is this file
use BukkitPE\event\Listener; // So it can listen when players are joining
use BukkitPE\event\player\PlayerJoinEvent;    // We will need to use this since we want to send the player the message onJoin

class Main extends PluginBase implements Listener{

public function onEnable() {
$this->getServer()->getPluginManager()->registerEvents($this, $this); // This is used to register events
}

public function onJoin(PlayerJoinEvent $event){

$event->getPlayer()->sendMessage("Welcome to my server");  // this will send the player that joined the server the message inside the "()"
}
}
