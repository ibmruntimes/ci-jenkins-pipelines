class Config24 {

    final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: 'xcode15.0.1',
                additionalTestLabels: [
                        openj9      : '!sw.os.osx.10_11',
                        temurin     : '!sw.os.osx.10_14'
                ],
                test                : 'default',
                configureArgs       : '--enable-dtrace',
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        x64Linux  : [
                os                  : 'linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerFile: [
                        openj9      : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'dev.functional',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system'
                        ]
                ],
                additionalTestLabels: [
                        openj9      : '!(centos6||rhel6)',
                        temurin     : '!(centos6||rhel6)'
                ],
                configureArgs       : [
                        'openj9'    : '--enable-dtrace',
                        'temurin'   : '--enable-dtrace'
                ],
                buildArgs           : [
                        'temurin'   : '--create-source-archive --create-jre-image --create-sbom --enable-sbom-strace --use-adoptium-devkit gcc-11.3.0-Centos7.9.2009-b03'
                ]
        ],

        x64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes',
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom --enable-sbom-strace'
                ]
        ],

        aarch64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : [
                        'openj9'    : '--enable-headless-only=yes',
                        'temurin'   : '--enable-headless-only=yes --with-jobs=4'
                ],
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom --enable-sbom-strace'
                ]
        ],

        x64Windows: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: 'win2022&&vs2022',
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [     
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'dev.functional',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system'
                        ]
            ],
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom --use-adoptium-devkit vs2022_redist_14.40.33807_10.0.26100.0'
                ]
        ],

        ppc64Aix    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: [
                        temurin: 'openxl17&&aix720',
                        openj9:  'xlc16&&aix715'
                ],
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'dev.functional',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system'
                        ]
                ],
                additionalTestLabels: [
                        temurin      : 'sw.os.aix.7_2TL5'
                ],
                cleanWorkspaceAfterBuild: true,
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        s390xLinux    : [
                os                  : 'linux',
                arch                : 's390x',
                dockerImage         : 'rhel7_build_image',
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'dev.functional',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system'
                        ]
                ],
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom --enable-sbom-strace --use-adoptium-devkit gcc-11.3.0-Centos7.9.2009-b03'
                ]
        ],

        ppc64leLinux    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'dev.functional',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system'
                        ]
                ],
                configureArgs       : [
                        'openj9'      : '--enable-dtrace'
                ],
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom --enable-sbom-strace --use-adoptium-devkit gcc-11.3.0-Centos7.9.2009-b03'
                ]
        ],

        aarch64Linux    : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                test: [
                        weekly : ['sanity.openjdk', 'sanity.system', 'extended.system', 'sanity.perf', 'sanity.functional', 'extended.functional', 'extended.openjdk', 'extended.perf', 'special.functional', 'special.openjdk', 'dev.functional', 'special.system']
                ],
                configureArgs       : [
                        'openj9'    : '--enable-dtrace',
                        'temurin'   : '--enable-dtrace --with-jobs=4'
                ],
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom --enable-sbom-strace --use-adoptium-devkit gcc-11.3.0-Centos7.6.1810-b03'
                ]
        ],

        aarch64Mac: [
                os                  : 'mac',
                arch                : 'aarch64',
                additionalNodeLabels: 'xcode15.0.1',
                test: [
                        weekly : ['sanity.openjdk', 'sanity.system', 'extended.system', 'sanity.perf', 'sanity.functional', 'extended.functional', 'extended.openjdk', 'extended.perf', 'special.functional', 'special.openjdk', 'dev.functional', 'dev.system']
                ],
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        riscv64Linux      :  [
                os                  : 'linux',
                arch                : 'riscv64',
                crossCompile        : 'qemustatic',
                dockerImage         : 'adoptopenjdk/ubuntu2004_build_image:linux-riscv64',
                dockerArgs          : '--platform linux/riscv64',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes --enable-dtrace',
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        aarch64Windows: [
                os                  : 'windows',
                arch                : 'aarch64',
                crossCompile        : 'x64',
                additionalNodeLabels: 'win2022&&vs2022',
                test                : 'default',
                buildArgs       : [
                        'temurin'   : '--create-jre-image --create-sbom --cross-compile --use-adoptium-devkit vs2022_redist_14.40.33807_10.0.26100.0'
                ]
        ]
  ]

}

Config24 config = new Config24()
return config.buildConfigurations
