targetConfigurations = [
        "x64Mac"        : [
                "openj9"
        ],
        "x64Linux"      : [
                "openj9"
        ],
        "x32Windows"    : [
                "openj9"
        ],
        "x64Windows"    : [
                "openj9"
        ],
        "ppc64Aix"      : [
                "openj9"
        ],
        "ppc64leLinux"  : [
                "openj9"
        ],
        "s390xLinux"    : [
                "openj9"
        ],
        "aarch64Linux"  : [
                "openj9"
        ]
]

// 18:05 Mon, Wed, Fri
triggerSchedule_nightly="TZ=UTC\n05 18 * * 1,3,5"
// 12:05 Sat
triggerSchedule_weekly="TZ=UTC\n05 12 * * 6"

// scmReferences to use for weekly release build
weekly_release_scmReferences=[
        "hotspot"        : "",
        "openj9"         : "",
        "corretto"       : "",
        "dragonwell"     : ""
]

return this
